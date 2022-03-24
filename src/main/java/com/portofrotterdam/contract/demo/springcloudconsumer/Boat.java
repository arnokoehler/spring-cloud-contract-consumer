package com.portofrotterdam.contract.demo.springcloudconsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boat {

    private int id;
    private String name;
    private int depth;

}
