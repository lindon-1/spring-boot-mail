package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: ldl
 * @Date: 2019/7/16 16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Msg {
    private String title;
    private String content;
    private String etraInfo;
}
