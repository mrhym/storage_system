package com.alibaba.hym.rt.storageSystem.web.controller;

import com.alibaba.hym.rt.storageSystem.api.GoodsService;
import com.alibaba.hym.rt.storageSystem.enums.ParamCodeEnums;
import com.alibaba.hym.rt.storageSystem.model.PageBean;
import com.alibaba.hym.rt.storageSystem.model.Result;
import com.alibaba.hym.rt.storageSystem.service.dao.GoodsDAO;
import com.alibaba.hym.rt.storageSystem.service.model.GoodsDTO;
import com.alibaba.hym.rt.storageSystem.service.model.PaginationDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/4/26 14:07
 **/
@RequestMapping("goods")
@RestController
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @Resource
    GoodsDAO goodsDAO;
    @RequestMapping("/uploadPic")
    public Result uploadProfile(@RequestParam("file") MultipartFile multipartFile) {
        return goodsService.uploadPic(multipartFile);
    }

    @RequestMapping("/addGoods")
    public Result addGoods(@RequestBody GoodsDTO goodsDTO) {
        if(goodsDTO == null){
            return Result.error(ParamCodeEnums.ERROR.getCode(),ParamCodeEnums.ERROR.getMsg());
        }
        return goodsService.addGoods(goodsDTO);
    }


    @RequestMapping("goodsAll")
    public Result GoodsAll(){
        return Result.success(goodsDAO.selectAll());
    }

    @RequestMapping("/goodsInfo")
    public Result addGoods(@RequestBody PaginationDO paginationDO) {

        //TODO 获取店面id

        if(paginationDO == null){
            return Result.error(ParamCodeEnums.ERROR.getCode(),ParamCodeEnums.ERROR.getMsg());
        }
        return Result.success(goodsDAO.selectByPage(paginationDO));
    }


    @RequestMapping("/count")
    public Result goodsCount() {

        //TODO 获取店面id
        return Result.success(goodsDAO.selectById());
    }
}
