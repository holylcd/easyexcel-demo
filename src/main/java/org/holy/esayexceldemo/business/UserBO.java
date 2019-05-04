package org.holy.esayexceldemo.business;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * @author holyl
 * @email holylcd@foxmail.com
 * @date 2019/5/4
 */
@Data
public class UserBO extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String code;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private String age;

    @ExcelProperty(index = 3)
    private String gender;

    @ExcelProperty(index = 4)
    private Date createDate;

    @ExcelProperty(index = 5)
    private Date modifiedDate;
}
