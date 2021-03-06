package com.chaos.valoraservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomVendor {
    
    private String id;
    private String type;
    private String status;
    private String vendorId;
    private String vendorName;

}
