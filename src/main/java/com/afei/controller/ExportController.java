package com.afei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

@RestController
public class ExportController {

    @GetMapping(value = "/export")
    public void testSingle(HttpServletRequest request, HttpServletResponse response)throws Exception{


        /*System.getProperties().list(System.out);


        String htmlStr="<head>";

        byte b[] = htmlStr.getBytes("utf-8");
        ByteArrayInputStream bais = new ByteArrayInputStream(b);

        POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry directory = poifs.getRoot();
        directory.createDocument("WordDocument", bais);



        String fileName="惺惺相惜的";
        //request.setCharacterEncoding("utf-8");
        response.setContentType("application/msword");//导出word格式
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(),"iso-8859-1")+
                ".doc");
        OutputStream ostream = response.getOutputStream();
        poifs.writeFilesystem(ostream);
        bais.close();
        ostream.close();*/
    }
}
