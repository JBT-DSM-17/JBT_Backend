package hello.jbtbe.domain.goods.entity;

public enum Category {
    STOCKFISH("건어물"),
    FRUITS_AND_VEGETABLES("청과류"),
    LIVESTOCK("축산물"),
    MARINE("수산물"),
    AGRICULTURAL("농산물");

    Category(String value) {
        this.value = value;
    }

    public final String value;
}
