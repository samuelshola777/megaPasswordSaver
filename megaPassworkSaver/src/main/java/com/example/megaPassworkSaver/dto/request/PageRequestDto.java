package com.example.megaPassworkSaver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class PageRequestDto {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;

    public Pageable getPageRequest(PageRequestDto pageRequestDto){
    Integer pageNo = Objects.nonNull(pageRequestDto.getPageNumber()) ? pageRequestDto.getPageNumber() : this.pageNumber;
    Integer pageSizes = Objects.nonNull(pageRequestDto.getPageSize()) ? pageRequestDto.getPageSize() : this.pageSize;
    PageRequest request = PageRequest.of(pageNumber, pageSizes);
  return (Pageable) request;
    }

}
