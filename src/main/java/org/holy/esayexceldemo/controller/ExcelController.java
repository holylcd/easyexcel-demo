package org.holy.esayexceldemo.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import org.holy.esayexceldemo.business.UserBO;
import org.holy.esayexceldemo.listener.ExcelListener;
import org.holy.esayexceldemo.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *
 * @author holyl
 * @email holylcd@foxmail.com
 * @date 2019/5/4
 */
@RestController
@RequestMapping(value = "/excel", produces = "application/vnd.app.v1+json")
public class ExcelController {

    @RequestMapping(value = "/object", method = RequestMethod.POST)
    public R in(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename().toUpperCase();
        if (!(originalFilename.endsWith(".XLSX") || originalFilename.endsWith(".XLS"))) {
            return R.err("不支持文件类型");
        }

        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();

        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(file.getInputStream());

            ExcelReader excelReader = new ExcelReader(
                    inputStream,
                    null,
                    listener
                );

            excelReader.read();
        } catch (Exception e) {

        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return R.ok(8)
                .count(listener.getDatas().size())
                .data(listener.getDatas())
                .put("RAM", Runtime.getRuntime().totalMemory()/(1024*1024));
    }

    @RequestMapping(value = "/model", method = RequestMethod.POST)
    public R inBo(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename().toUpperCase();
        if (!(originalFilename.endsWith(".XLSX") || originalFilename.endsWith(".XLS"))) {
            return R.err("不支持文件类型");
        }

        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();

        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(file.getInputStream());

            ExcelReader excelReader = new ExcelReader(
                    inputStream,
                    null,
                    listener
            );

            // sheetNo:从1开始  headLineMun:表头行数。默认为1
            excelReader.read(new Sheet(1, 1, UserBO.class));
        } catch (Exception e) {

        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return R.ok(8)
                .count(listener.getDatas().size())
                .data(listener.getDatas())
                .put("RAM", Runtime.getRuntime().totalMemory()/(1024*1024));
    }
}
