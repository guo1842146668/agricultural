package com.puyan.shengren.agricultural.service;

import com.puyan.shengren.agricultural.enity.Work;
import com.puyan.shengren.agricultural.common.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: WorkService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 14:27
 * @Version: 1.0
 **/
public interface WorkService {

    Result insert(Work work);

    Result delete(Integer workID);

    Result update(Work work);

    Result getAll(Work work,Integer page,Integer count);

    Result uploadImgs(@RequestParam("file") MultipartFile[] files, Integer workID);

    List<Map<String,Object>> upExcel(Work work);
}
