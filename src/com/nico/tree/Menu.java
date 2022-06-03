package com.nico.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/03/18/17:59
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer id;

    private Integer parentId;

    private String name;

    private List<Menu> childList;

    public Menu(Integer id,String name,Integer parentId){
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
