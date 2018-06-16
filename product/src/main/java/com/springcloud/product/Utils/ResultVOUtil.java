package com.springcloud.product.Utils;

import com.springcloud.product.VO.ResultVO;

/**
 * @Author: wangcheng
 * @Date: Created in 14:45 2018/6/12
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
