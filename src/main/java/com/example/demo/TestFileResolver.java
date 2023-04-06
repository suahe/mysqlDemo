package com.example.demo;

import com.alibaba.otter.node.extend.fileresolver.AbstractFileResolver;
import com.alibaba.otter.shared.etl.extend.fileresolver.FileInfo;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestFileResolver
 * @Author: cqt123456789
 * @CreateTime: 2022/6/28 9:33
 * @Description:
 */
public class TestFileResolver extends AbstractFileResolver {

    public static void main(String[] args) {
        String a = "https://hb-app.linkhyperion.cn/industrial/file/industrial/file/downloadFiles/industrial/2022-06-30/607dd5ddd0f642bba8a3d6a86916c661/地表水环境质量数据报表_1656601640251.xlsx";

        String b = a.split("https://hb-app.linkhyperion.cn/industrial")[0];
        String c = a.split("https://hb-app.linkhyperion.cn/industrial")[1];
        String d = c.split("/file/industrial")[1];
        System.out.println("https://hb-app.linkhyperion.cn/industrial"+d);
    }

    @Override
    public FileInfo[] getFileInfo(Map<String, String> rowMap) {
        String url = "https://ans-onlines.linkhyperion.cn:9092/";
        // 基本步骤：
        // 1. 获取binlog中的变更字段，比如组成文件有多个字段组成version+path
        // 2. 基于字段内容，构造一个文件路径，目前开源版本只支持本地文件的同步.(如果是网络文件，建议进行NFS mount到ndde机器).
        // 3. 返回FileInfo数组，(目前不支持目录同步，如果是目录需要展开为多个FileInfo的子文件)，如果不需要同步，则返回null.
        String pic_url = rowMap.get("PIC_URL"); //注意为大写
        String detail_pic_url = rowMap.get("DETAIL_PIC_URL"); //注意为大写
        String advert_url = rowMap.get("ADVERT_URL"); //注意为大写
        List<FileInfo> fileInfoList = new ArrayList<>();
        FileInfo fileInfo = null;
        if (StringUtils.isNotEmpty(pic_url)) {
            String[] pic_urls = pic_url.split(url);
            fileInfo = new FileInfo("/usr/local/project/xuefa/"+pic_urls[1]);
            fileInfoList.add(fileInfo);
        }
        if (StringUtils.isNotEmpty(detail_pic_url)) {
            String[] detail_pic_urls = detail_pic_url.split(url);
            fileInfo = new FileInfo("/usr/local/project/xuefa/"+detail_pic_urls[1]);
            fileInfoList.add(fileInfo);
        }
        if (StringUtils.isNotEmpty(advert_url)) {
            String[] advert_urls = advert_url.split(url);
            fileInfo = new FileInfo("/usr/local/project/xuefa/"+advert_urls[1]);
            fileInfoList.add(fileInfo);
        }
        if(fileInfoList.size()>0) {
            FileInfo[] fileInfos = new FileInfo[fileInfoList.size()];
            fileInfos = fileInfoList.toArray(fileInfos);
            return fileInfos;
        }else {
            return null;
        }
    }

}