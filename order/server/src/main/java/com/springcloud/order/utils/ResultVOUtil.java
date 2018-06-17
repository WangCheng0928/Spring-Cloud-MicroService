package com.springcloud.order.utils;

import com.springcloud.order.VO.ResultVO;

/**
 * @Author: wangcheng
 * @Date: Created in 11:46 2018/6/14
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
