package com.puyan.shengren.agricultural.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.puyan.shengren.agricultural.Dao.WorkDao;
import com.puyan.shengren.agricultural.Enity.Work;
import com.puyan.shengren.agricultural.Service.WorkService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: WorkServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 14:28
 * @Version: 1.0
 **/
@Service
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    @Override
    public Result insert(Work work) {
        if(work == null){
            return ResultUtil.error(500,"参数错误");
        }
        if(work.getWorkMachineryID() == null){
            return ResultUtil.error(500,"机械ID不能为空");
        }
        int resCount = workDao.insert(work);
        if(resCount == 0){
            return ResultUtil.error(400,"录入失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result delete(Integer workID) {
        if(workID == 0){
            return  ResultUtil.error(500,"作业ID不能为空");
        }
        int resCount = workDao.delete(workID);
        if(resCount == 0){
            return  ResultUtil.error(400,"删除失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result update(Work work) {
        if(work == null){
            return ResultUtil.error(500,"参数错误");
        }
        int resCount = workDao.update(work);
        if(resCount == 0){
            return  ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result getAll(Work work,Integer page,Integer count) {
        //创建分页对象
        PageHelper.startPage(page,count);
        List<Work> workList = workDao.getAll(work);
        if(workList.isEmpty()){
            return  ResultUtil.success(null);
        }
        PageInfo<Work> pageInfo = new PageInfo<>(workList);
        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result uploadImgs(MultipartFile[] files, Integer workID) {
        Work work=new Work();
        work.setWorkID(workID);
        List<Work> all = workDao.getAll(work);
        if(all.size() != 1){
            return ResultUtil.error(500,"请传入有效的workID");
        }
        Work workall = all.get(0);
        List<String> resultFile=new ArrayList<>();
        File flie = new File("image"+File.separator+workall.getMachinery().getMachineryNO()+File.separator+workall.getWorkID());
        if(flie.exists()) {
            flie.mkdir();
        }
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            String targetUploadPath = flie + File.separator + filename;
            try {
                FileUtils.writeByteArrayToFile(new File(targetUploadPath), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return ResultUtil.error(400,"错误位置为："+originalFilename);
            }
            resultFile.add("成功上传："+originalFilename);
        }

        return ResultUtil.success(resultFile);
    }
}
