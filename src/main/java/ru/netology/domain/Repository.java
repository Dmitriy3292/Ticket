package ru.netology.domain;



public class Repository {
    private Ticket[] tikets = new Ticket[0];

    public void add(Ticket tiket) {       //добавить
        int leng = tikets.length + 1;
        Ticket[] temp = new Ticket[leng];
        System.arraycopy(tikets, 0, temp, 0, tikets.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = tiket;
        tikets = temp;
    }

    public Ticket[] findAll() {            //получить список
        return tikets;
    }

    public void removeById(int id) {      //удалить
        int leng = tikets.length + 1;
        Ticket[] temp = new Ticket[leng];
        int index = 0;
        for (Ticket tiket : tikets) {
            if (tiket.getId() != id) {
                temp[index] = tiket;
                index++;
            }
        }
        tikets = temp;
    }
}