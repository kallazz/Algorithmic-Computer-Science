--zadanie_5, Michał Kallas
with Ada.Text_IO;
with Ada.Integer_Text_IO;

procedure Zadanie_5 is
    n : Integer;
    spaces : Integer;
    row_size : Integer;
begin
    Ada.Text_IO.Put("Podaj n:");
    Ada.Integer_Text_IO.Get(n);
    spaces := n - 1;
    row_size := 1;

    for i in 1 .. n loop
        for j in 1 .. spaces loop
            Ada.Text_IO.Put(" ");  
        end loop;

        for j in 1 .. row_size loop
            Ada.Text_IO.Put("*");  
        end loop;
        Ada.Text_IO.New_Line;

        spaces := spaces - 1;
        row_size := row_size + 2;
    end loop;
end Zadanie_5;
