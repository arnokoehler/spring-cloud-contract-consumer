package com.portofrotterdam.contract.demo.springcloudconsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoatsResponse {

    private List<Boat> boats;
}
