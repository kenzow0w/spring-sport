package org.sport.foot.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamRequest extends PageRequest {
    protected TeamRequest(int page, int size) {
        super(page, size, Sort.by("name"));
    }
}
