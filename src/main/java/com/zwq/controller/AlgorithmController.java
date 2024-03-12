package com.zwq.controller;

import com.zwq.pojo.Algorithm;
import com.zwq.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
public class AlgorithmController {
    @Autowired
    @Qualifier("AlgorithmServiceImpl")
    private AlgorithmService algorithmService;

    @RequestMapping("/goAlgorithm")
    public String goAlgorithm() {
        return "algorithmPage";
    }

    @RequestMapping("selectAlgorithmById")
    public String selectAlgorithmById(HttpSession session){
        int userId = (int) session.getAttribute("presentUserId");
        System.out.println("当前用户id为： "+userId);

        List<Algorithm> algorithmList = algorithmService.selectAlgorithmById(userId);
        System.out.println("查询得到的集合个数为： "+algorithmList.size());
        for (Algorithm algorithm : algorithmList) {
            System.out.println("算法名称：" + algorithm.getAlgorithm_name());
            System.out.println("userid：" + algorithm.getUser_id());
        }
        session.setAttribute("algorithmList",algorithmList);

        return "algorithmPage";
    }

    @RequestMapping("selectAlgorithmByKeyword")
    public String selectAlgorithmByKeyword(HttpSession session,@RequestParam(value = "keyword") String keyword){
        System.out.println("keyword:"+keyword);
        if (keyword == null){
            keyword = "%%";
        }else {
            keyword = "%" + keyword + "%";
        }
        System.out.println("keyword:"+keyword);

        List<Algorithm> algorithmList = algorithmService.selectAlgorithmByName(keyword);

        System.out.println("查询得到的集合个数为： "+algorithmList.size());
        for (Algorithm algorithm : algorithmList) {
            System.out.println("算法名称：" + algorithm.getAlgorithm_name());
            System.out.println("userid：" + algorithm.getUser_id());
        }
        session.setAttribute("algorithmList",algorithmList);

        return "algorithmPage";
    }

    @PostMapping("/upLoad")
    public String save(MultipartFile some, HttpServletRequest request) {
        HttpSession session=request.getSession();

//        String path = session.getServletContext().getRealPath("/upload");
        String path = "D:\\IDEA_UI_CODE\\Project\\Project06\\src\\main\\webapp\\upload";
        System.out.println("物理路径：" + path);

        String fileName = some.getOriginalFilename();
        fileName = UUID.randomUUID() + fileName;

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的文件类型为：" + suffix);

        long size = some.getSize();
        System.out.println(size);

        if (size > 500000 * 1024) {
            session.setAttribute("error1", "文件过大");
            System.out.println("111");
            return "algorithmPage";
        } else if (suffix.equalsIgnoreCase(".md") || suffix.equalsIgnoreCase(".jpg")) {
            File file = new File(new File(path), fileName);
            //不存在创建
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                //把文件写入磁盘
                some.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                session.setAttribute("error2", "文件上传失败!");
                System.out.println("222");
                return "algorithmPage";
            }

        } else {
            session.setAttribute("error3", "不支持上传该类型文件！");
            System.out.println("333");
            return "algorithmPage";
        }

        session.setAttribute("success", "上传成功！");
        System.out.println(fileName);

        Algorithm algorithm = new Algorithm();

        algorithm.setUser_id((Integer) session.getAttribute("presentUserId"));
        algorithm.setAlgorithm_name(fileName);
        algorithm.setWay(path);

        int i = algorithmService.addAlgorithm(algorithm);
        System.out.println("添加算法影响的行数："+i);
        if (i > 0){
            session.setAttribute("success_add","添加算法成功！");
        }else {
            session.setAttribute("error_add","添加算法失败，请重试！");
        }


        return "algorithmPage";
    }

    @RequestMapping("/down")
    public void downLoad(int id, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        HttpSession session = request.getSession();

        Algorithm algorithm = algorithmService.selectOneAlgorithmById(id);
        System.out.println("way:"+algorithm.getWay());
        System.out.println("Algorithm_name:"+algorithm.getAlgorithm_name());

//        String filePath = session.getServletContext().getRealPath("/upload");
        String filePath = algorithm.getWay();
        String name = algorithm.getAlgorithm_name();

        File file = new File(filePath);


        try {
            InputStream in = new FileInputStream(new File(file,name));
            //通过浏览器以下载的方式打开
            response.addHeader("Content-Type","application/octet-stream");
            response.addHeader("Content-Disposition","attachment;filename="+name);
            OutputStream out = response.getOutputStream();
            //流的复制
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len =in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String deleteAlgorithm(int id,HttpServletRequest request){
        int i = algorithmService.deleteAlgorithmById(id);
        HttpSession session = request.getSession();

        if (i > 0){
            session.setAttribute("yeah","删除成功！");
        }else {
            session.setAttribute("no","删除失败！");
        }
        return "algorithmPage";
    }

}
