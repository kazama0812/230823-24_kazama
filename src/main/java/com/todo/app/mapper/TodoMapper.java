package com.todo.app.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;
@Mapper
public interface TodoMapper {
//    public List<Todo> selectAll();
	//タイトル順
    public List<Todo> selectTitle();
    //期限順
    public List<Todo> selectTime();
    //完了済み
    public List<Todo> selectComplete();
    
    public void add(Todo todo);
    public void update(Todo todo);
    public void delete();
}









