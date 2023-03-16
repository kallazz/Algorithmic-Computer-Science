--Zadanie 3.adb, Michał Kallas
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Text_IO; use Ada.Text_IO;
procedure Zadanie3 is 
    sum : Float := 1.0;
    denominator : Float := 1.0;
begin
    while sum <= 10.0 loop
        denominator := denominator + 1.0;
        sum := sum + (1.0/denominator);
    end loop;

    Put("Poszukiwane n to:");
    Put(denominator);
end Zadanie3;