package com.webserver.server.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Tsuhang Liang(Nero Ransom) CUG
 * @Date: 2021/5/13 17:48
 * @Description: update text by user.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TextUpdate {
    private String username;
    private String password;
    private String path;
}

