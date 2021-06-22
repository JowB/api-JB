package com.jb.apijb.page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PageDTO {

    private long id;
    private String title;
    private String subTitle;
}
