import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class TodoItem(
    val name: String, val description: String, val dueDate: LocalDate, var completed: Boolean = false
) {
    override fun toString(): String {
        val formattedDueDate = dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        return "TodoItem(name='$name', description='$description', dueDate='$formattedDueDate', completed=$completed)"
    }
}

class TodoList {
    private val items: MutableList<TodoItem> = mutableListOf()

    fun add(item: TodoItem) {
        items.add(item)
    }

    fun remove(item: TodoItem) {
        items.remove(item)
    }

    fun statusCompleted(item: TodoItem) {
        item.completed = true
    }

    fun statusIncompleted(item: TodoItem) {
        item.completed = false
    }

    fun getAllItems(): List<TodoItem> {
        return items.toList()
    }

    fun getCompletedItems(): List<TodoItem> {
        return items.filter { it.completed }
    }

    fun getIncompletedItems(): List<TodoItem> {
        return items.filter { !it.completed }
    }
}

fun main() {


    val myTodoList = TodoList()

    print("Your name: ")
    val user = readln().capitalize()

    while (true) {


        print("$user, choose your operation(add,remove,get all,get completed,get incompleted, Change Status) or type 'exit' to exit: ")

        val operation = readln().toLowerCase()


        val allItems = myTodoList.getAllItems()

        if (operation == "add") {
            // ToDo list name
            print("ToDo name: ")
            val todoName = readln().toString()

            // ToDo list Description
            print("ToDo description: ")
            val todoDescription = readln()

            // ToDo list Date
            print("Enter ToDo date in MM/DD/YYYY format: ")
            val userInput = readln()

            val dateParts = userInput.split("/")

            if (dateParts.size != 3) {
                throw IllegalArgumentException("Invalid date format. Please use MM/DD/YYYY format.")
            }

            val day = dateParts[0].toInt()
            val month = dateParts[1].toInt()
            val year = dateParts[2].toInt()

            if (month !in 1..12) {
                throw IllegalArgumentException("$user, You entered an invalid month value. Please enter a month between 1 and 12.")
            }
            if (day !in 1..31) {
                throw IllegalArgumentException("$user, You entered an invalid day value. Please enter a day between 1 and 31.")
            }
            if (year !in 0..9999) {
                throw IllegalArgumentException("$user, You entered an invalid year value. Please enter a year between 0 and 9999.")
            }

            myTodoList.add(TodoItem(todoName, todoDescription, LocalDate.of(year, month, day), completed = false))

            println("$user, \"$todoName\" succesfully added\n")


        } else if (operation == "remove") {

            if (allItems.isNotEmpty()) {
                println("Choose the item to remove:")
                allItems.forEachIndexed { index, item ->
                    val status = if (item.completed) "completed" else "not completed"
                    println(
                        "${index + 1}. ${item.name}, ${item.description}, (${
                            item.dueDate.format(
                                DateTimeFormatter.ofPattern(
                                    "MM/dd/yyyy"
                                )
                            )
                        }), is $status"
                    )
                }

                print("Enter the number of the item to remove: ")

                val choice = readln().toIntOrNull()

                if (choice != null && choice in 1..allItems.size) {
                    val selectedItem = allItems[choice - 1]
                    myTodoList.remove(selectedItem)
                    println("$user, \"${selectedItem.name}\" successfully removed\n")
                } else {
                    println("Invalid choice. Please enter a valid number.\n")
                }
            } else {
                println("The ToDo list is empty.\n")
            }

        } else if (operation == "getall" || operation == "get all") {

            if (allItems.isNotEmpty()) {
                println("$user's ToDo List:")
                allItems.forEachIndexed { index, item ->
                    val status = if (item.completed) "completed" else "not completed"
                    println(
                        "${index + 1}. ${item.name}, ${item.description}, (${
                            item.dueDate.format(
                                DateTimeFormatter.ofPattern(
                                    "MM/dd/yyyy"
                                )
                            )
                        }), is $status"
                    )
                }
            } else {
                println("The ToDo list is empty.\n")
            }
        } else if (operation == "getcompleted" || operation == "get completed") {
            val completedItems = myTodoList.getCompletedItems()

            if (completedItems.isNotEmpty()) {
                println("Completed items:")
                completedItems.forEachIndexed { index, item ->
                    println(
                        "${index + 1}. ${item.name}, ${item.description}, (${
                            item.dueDate.format(
                                DateTimeFormatter.ofPattern(
                                    "MM/dd/yyyy"
                                )
                            )
                        }), is completed"
                    )
                }
            } else {
                println("No completed items.\n")
            }
        } else if (operation == "getincompleted" || operation == "get incompleted") {
            val completedItems = myTodoList.getIncompletedItems()

            if (completedItems.isNotEmpty()) {
                println("Incompleted items:")
                completedItems.forEachIndexed { index, item ->
                    println(
                        "${index + 1}. ${item.name}, ${item.description}, (${
                            item.dueDate.format(
                                DateTimeFormatter.ofPattern(
                                    "MM/dd/yyyy"
                                )
                            )
                        }), is not completed"
                    )
                }
            } else {
                println("No completed items.\n")
            }
        }else if(operation == "changestatus" || operation == "change status"){
            if (allItems.isNotEmpty()) {
                println("Choose the item to change status:")
                allItems.forEachIndexed { index, item ->
                    val status = if (item.completed) "completed" else "not completed"
                    println(
                        "${index + 1}. ${item.name}, ${item.description}, (${
                            item.dueDate.format(
                                DateTimeFormatter.ofPattern(
                                    "MM/dd/yyyy"
                                )
                            )
                        }), is $status"
                    )
                }

                print("Enter the number of the item to change status: ")

                val choice = readln().toIntOrNull()

                if (choice != null && choice in 1..allItems.size) {
                    val selectedItem = allItems[choice - 1]
                    if (selectedItem.completed) {
                        myTodoList.statusIncompleted(selectedItem)
                        println("$user, \"${selectedItem.name}\" status changed to incompleted\n")
                    } else {
                        myTodoList.statusCompleted(selectedItem)
                        println("$user, \"${selectedItem.name}\" status changed to completed\n")
                    }
                } else {
                    println("Invalid choice. Please enter a valid number.\n")
                }
            } else {
                println("The ToDo list is empty.\n")
            }
        }else if (operation == "exit"){
            print("See you, $user")
            break
        }else{
            println("Invalid value.  Please Try again")
        }


    }

}
