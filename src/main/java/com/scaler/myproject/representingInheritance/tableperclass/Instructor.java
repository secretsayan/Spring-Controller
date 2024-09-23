package com.scaler.myproject.representingInheritance.tableperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
}
