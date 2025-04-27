package com.example.util;

import com.example.models.Personel;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PagerUtil {

    public boolean isNullOrEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    public Pageable toPageable(RestPageableRequest pageableRequest) {
        if (!isNullOrEmpty(pageableRequest.getColumnName())){
            Sort sortBy = pageableRequest.isAsc() ? Sort.by(Sort.Direction.ASC, pageableRequest.getColumnName()) : Sort.by(Sort.Direction.DESC, pageableRequest.getColumnName());
            return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize(), sortBy);
        }
        return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize());
    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content){
        RestPageableEntity<T> restPageableEntity = new RestPageableEntity<>();
        restPageableEntity.setContent(content);
        restPageableEntity.setPageNumber(page.getPageable().getPageNumber());
        restPageableEntity.setPageSize(page.getPageable().getPageSize());
        restPageableEntity.setTotalElements(page.getTotalElements());
        return restPageableEntity;
    }
}
