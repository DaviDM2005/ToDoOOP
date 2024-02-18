
**Project Name:** ToDo List Kotlin OOP

**Description:**

A Kotlin program that implements a simple, interactive to-do list application. Users can add, remove, view, and mark items as completed, providing convenient task management and organization.

**Features:**

- Create to-do items with name, description, and due date.
- Remove items from the list.
- View all items, completed items, or incompleted items.
- Mark items as completed or incompleted.
- User-friendly interactive interface for efficient interaction.

**Getting Started:**

1. **Prerequisites:**
   - Java Development Kit (JDK) 1.8 or later: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
   - Kotlin development environment (e.g., IntelliJ IDEA, Android Studio): [https://kotlinlang.org/](https://kotlinlang.org/)
2. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-project-name.git
   ```
3. **Open the project in your IDE:**
   - Import the project into your chosen IDE.
4. **Build and run the project:**
   - Follow the specific instructions within your IDE to build and run the program.

**Usage:**

The program prompts the user for their name and then presents a menu of options:

- `add`: Add a new to-do item by providing its name, description, and due date.
- `remove`: Remove an existing item by selecting its number from the list.
- `get all`: View all items in the list.
- `get completed`: View only completed items.
- `get incompleted`: View only incompleted items.
- `changestatus`: Change the completion status of an item.
- `exit`: Exit the program.

**Example:**

**Output:**

```
Your name: Bob

Bob, choose your operation(add,remove,get all,get completed,get incompleted, Change Status) or type 'exit' to exit: add
ToDo name: Buy groceries
ToDo description: Milk, bread, eggs
Enter ToDo date in MM/DD/YYYY format: 02/19/2024

Bob, "Buy groceries" successfully added

Bob, choose your operation(add,remove,get all,get completed,get incompleted, Change Status) or type 'exit' to exit: get all

Bob's ToDo List:
1. Buy groceries, Milk, bread, eggs, (02/19/2024), is not completed

Bob, choose your operation(add,remove,get all,get completed,get incompleted, Change Status) or type 'exit' to exit: exit

See you, Bob
```

**Additional Notes:**

- Feel free to customize the project name, descriptions, and messages to suit your preferences.
- You can also extend the functionality by adding more features, such as sorting, reminders, or priority levels.


