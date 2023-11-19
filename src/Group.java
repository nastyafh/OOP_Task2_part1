import java.util.List;
//Этот класс отвечает за группу. Опираясь на json файл, в нем я создала поле group, обозначяющее номер группы
// и поле, обозначающее расписание для группы (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.
public class Group {
    private int group;
    private List<Shedule> shedule;

    public Group(int group,List<Shedule> shedule) {
        this.group = group;
        this.shedule = shedule;
    }

    public List<Shedule> getShedule() {
        return shedule;
    }

    public void setShedule(List<Shedule> shedule) {
        this.shedule = shedule;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + group +
                ", shedule=" + shedule +
                '}';
    }
}
