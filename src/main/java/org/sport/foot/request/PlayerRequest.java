package org.sport.foot.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {
    String firstName;
    String lastName;
    String secondName;
    String email;
    Integer ratingFrom;
    Integer ratingTo;
    UUID teamId;
    UUID roleId;
    UUID positionId;
    int page;
    int size;
}
