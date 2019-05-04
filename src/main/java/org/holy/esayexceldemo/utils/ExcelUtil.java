package org.holy.esayexceldemo.utils;

import com.alibaba.excel.metadata.BaseRowModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author holyl
 * @email holylcd@foxmail.com
 * @date 2019/5/4
 */
public class ExcelUtil {

    public static List<BaseRowModel> readExcel(MultipartFile excel, BaseRowModel rowModel) {
        ArrayList<BaseRowModel> baseRowModels = new ArrayList<>();

        return baseRowModels;
    }

}