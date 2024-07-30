public class Main {
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class TaskManagementSystem {
        private Node head;

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task.getTaskName());
                current = current.next;
            }
        }

        public void deleteTask(int taskId) {
            if (head == null) return;

            if (head.task.getTaskId() == taskId) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.getTaskId() == taskId) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        private class Node {
            Task task;
            Node next;

            public Node(Task task) {
                this.task = task;
                this.next = null;
            }
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        Task task1 = new Task(1, "Task 1", "Pending");
        Task task2 = new Task(2, "Task 2", "In Progress");

        tms.addTask(task1);
        tms.addTask(task2);

        System.out.println("Tasks:");
        tms.traverseTasks();

        Task foundTask = tms.searchTask(1);
        System.out.println("Found Task: " + foundTask.getTaskName());

        tms.deleteTask(1);

        System.out.println("Tasks after deletion:");
        tms.traverseTasks();
    }
}

