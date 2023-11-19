//Этот класс отвечает за расписание конкретной группы конкретного курса.
//Опираясь на json файл, в нем я создала поле week, обозначяющее название недели (числитель или знаменатель)
// и поле, обозначающее день недели, для которого ищется расписание (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.





import java.util.List;

public class Shedule {
    private String week;
    private List<Day> day;

    public Shedule(String week, List<Day> day) {
        this.week = week;
        this.day = day;
    }

    public Shedule() {
    }

    @Override
    public String toString() {
        return "Shedule{" +
                "week='" + week + '\'' +
                ", day=" + day +
                '}';
    }

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
