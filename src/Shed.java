//Этот класс отвечает за курс. Опираясь на json файл, в нем я создала поле course, обозначяющее номер курса
// и поле, обозначающее номер группы (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.



import java.util.List;

public class Shed {
    private int course;
    private List<Group> group;

    public Shed(int course, List<Group> group) {
        this.course = course;
        this.group = group;
    }

    public Shed() {
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Group> getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }
    public String toString(){
        return "{" +
                "course= " + course + '\'' +
                ", group= " + group +
                '}';
    }
}
