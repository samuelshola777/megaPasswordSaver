package com.example.megaPassworkSaver.dto.request;

import com.restfb.types.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;
    private String token ;
    private String appUserEmail;

    public Pageable getPageRequest(PageRequestDto pageRequestDto){
    Integer pageNo = Objects.nonNull(pageRequestDto.getPageNumber()) ? pageRequestDto.getPageNumber() : this.pageNumber;
    Integer pageSizes = Objects.nonNull(pageRequestDto.getPageSize()) ? pageRequestDto.getPageSize() : this.pageSize;
        return PageRequest.of(pageNo,pageSizes);
    }

}
