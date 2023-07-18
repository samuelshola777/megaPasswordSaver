package com.example.megaPassworkSaver.dto.request;

import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;

    public PageRequest getPageRequest(PageRequest pageRequest){

    }

}
