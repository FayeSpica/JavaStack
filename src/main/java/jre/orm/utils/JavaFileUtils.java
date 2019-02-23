package jre.orm.utils;

import jre.orm.bean.ColumnInfo;
import jre.orm.bean.JavaFieldGetSet;
import jre.orm.bean.KeyType;
import jre.orm.bean.TableInfo;
import jre.orm.core.DBManager;
import jre.orm.core.MySQLTypeConverter;
import jre.orm.core.TableContext;
import jre.orm.core.TypeConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liaowm5
 * @version 1.0
 * @description 封装了Java文件(源代码)的操作
 * @date 2019-02-23 08:27
 **/
public class JavaFileUtils {

    /**
     * @description: 根据字段信息生成Java类
     * @param column 1 字段信息
     * @param converter 2 转化器
     * @return: jre.orm.bean.JavaFieldGetSet
     **/
    public static JavaFieldGetSet createFieldGetSet(ColumnInfo column, TypeConverter converter){
        JavaFieldGetSet javaFieldGetSet = new JavaFieldGetSet();
        String javaFieldType = converter.dbType2JavaType(column.getDataType());

        javaFieldGetSet.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");

        //public String getUsername(){return username;}
        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.getCamelFormat(column.getName())+"(){\n");
        getSrc.append("\t\treturn this."+column.getName()+";\n");
        getSrc.append("\t}\n");

        javaFieldGetSet.setGetInfo(getSrc.toString());

        //public void setUsername(){return this.username = username;}
        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set"+StringUtils.getCamelFormat(column.getName())+
                "("+javaFieldType+" "+column.getName()+"){\n");
        setSrc.append("\t\t this."+column.getName()+" = "+column.getName()+";\n");
        setSrc.append("\t}\n");

        javaFieldGetSet.setSetInfo(setSrc.toString());

        return javaFieldGetSet;
    }

    /**
     * @description: 根据表信息
     * @param tableInfo 1
     * @param converter 2
     * @return: java.lang.String
     **/
    public static String createJavaSourse(TableInfo tableInfo,TypeConverter converter){

        Map<String,ColumnInfo> columnInfoMap = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFieldGetSets = new ArrayList<>();

        for(ColumnInfo columnInfo:columnInfoMap.values()){
            javaFieldGetSets.add(createFieldGetSet(columnInfo,MySQLTypeConverter.getInstance()));
        }

        StringBuilder src = new StringBuilder();
        src.append("package "+ DBManager.getConf().getPoPackage()+";\n\n");

        src.append("import java.sql.*;\n");
        src.append("import java.util.*;\n\n");

        src.append("public class "+StringUtils.getCamelFormat(tableInfo.getName())+" {\n");

        //生成属性列表
        for(JavaFieldGetSet fieldGetSet:javaFieldGetSets){
            src.append(fieldGetSet.getFieldInfo());
        }

        System.out.println("\n\n");

        //生成getter
        for (JavaFieldGetSet fieldGetSet:javaFieldGetSets){
            src.append(fieldGetSet.getGetInfo());
        }

        //生成setter
        for (JavaFieldGetSet fieldGetSet:javaFieldGetSets){
            src.append(fieldGetSet.getSetInfo());
        }

        src.append("}\n");
        System.out.println(src.toString());
        return src.toString();
    }


    /**
     * @description: 生成Java类文件
     * @param tableInfo 1 数据库表字段信息
     * @param converter 2 数据库表&Java类转化器
     * @return: void
     **/
    public static void createJavaPOFile(TableInfo tableInfo,TypeConverter converter){
        String src = createJavaSourse(tableInfo,converter);

        String srcPath = DBManager.getConf().getSrcPath();
        String packagePath = DBManager.getConf().getPoPackage().replace('.','/');

        File file = new File(srcPath+packagePath);

        System.out.println(file.getAbsolutePath()+"---->");

        //System.exit(0);

        if(!file.exists()){
            if(!file.mkdirs())
                throw new RuntimeException("file create error");
        }

        //System.exit(0);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(srcPath+packagePath+"/"+
                    StringUtils.getCamelFormat(tableInfo.getName())+".java"));
            bw.write(src);
            System.out.println("建立表"+tableInfo.getName()+"对应的Java类:"+StringUtils.getCamelFormat(tableInfo.getName())+".java");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){

    }
}
