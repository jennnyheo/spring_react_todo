package backend.service

import backend.repository.Todo
import backend.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoService (
    private val todoRepository: TodoRepository
        ){
    fun getTodos() = todoRepository.findAll()
    //funtion getTodos 호출하면 todoRepository 에 있는 모든 내용 find

    fun insertTodo(todoName : String): Todo = todoRepository.save(Todo(todoName = todoName));
    //return 해준다.

    fun updateTodo(todoId : Long): Todo{
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw Exception() // 없으면 Exception 발생
        todo.completed = !todo.completed
        return todoRepository.save(todo);
    }

    fun deleteTodo(todoId : Long) = todoRepository.deleteById(todoId);


}