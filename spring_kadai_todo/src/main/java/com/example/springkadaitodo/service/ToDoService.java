package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
		 private final ToDoRepository todoRepository;

		    // 依存性の注入（DI）を行う（コンストラクタインジェクション）
		    public ToDoService(ToDoRepository todoRepository) {
		        this.todoRepository = todoRepository;
		    }

		   /*// 新規ユーザーの登録メソッド
		    public void createUser(String todoTitle, String todoPriority, String status) {
		        // ユーザー名の未入力チェック（空欄はNG）
		        if (todoTitle == null || todoTitle.isEmpty()) {
		            throw new IllegalArgumentException("タイトルを入力してください。");
		        }

		        // ユーザー名の重複チェック（完全一致はNG）
		        if (!todoRepository.findBytodoTitle(todoTitle).isEmpty()) {
		            throw new IllegalArgumentException("そのタイトルは既に使用されています。");
		        }
		     // ユーザー登録用のエンティティを作成
		        ToDo todo = new ToDo();
		        todo.setTodoTitle(todoTitle);
		        todo.setTodoPriority(todoPriority);
		        todo.setTodoStatus(status);

		        // ユーザーの登録
		        todoRepository.save(todo);
		    }  */

		    // ユーザーの一括取得メソッド
		    public List<ToDo> getAllTodos() {
		        return todoRepository.findAll();
		    }
		

	}



