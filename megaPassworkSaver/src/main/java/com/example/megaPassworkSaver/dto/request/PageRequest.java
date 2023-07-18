package com.example.megaPassworkSaver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.print.Pageable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class PageRequest {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;

    public Pageable getPageRequest(PageRequest pageRequest){
    Integer pageNo = Objects.nonNull(pageRequest.getPageNumber()) ? pageRequest.getPageNumber() : this.pageNumber;
    Integer pageSizes = Objects.nonNull(pageRequest.getPageSize()) ? pageRequest.getPageSize() : this.pageSize;
    PageRequest request = PageRequest.
    }

}
