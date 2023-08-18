package com.comic.blank.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {

    private String id;

    private String parentId;

    private String text;

    private String url;

    private String yxbz;

    private List<Menu> children;

    public Menu(String id, String parentId, String text, String url, String yxbz) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.url = url;
        this.yxbz = yxbz;
    }

}
