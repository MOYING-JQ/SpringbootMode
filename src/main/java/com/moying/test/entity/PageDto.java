package com.moying.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 墨莹
 * @date 2026/11/24 15:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {


    public Long current;
    public Long size;

    private Long id;

    private String username;

    private String email;

    //排序字段 age / create_time
    private String sortField;
    //排序方式 asc / desc
    private String sortOrder;

}
