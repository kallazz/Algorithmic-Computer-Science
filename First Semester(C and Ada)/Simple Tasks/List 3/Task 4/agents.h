#pragma once

struct agent {
    int x;
    int y;
};

struct agent newagent(int x, int y);
double distance(struct agent a1, struct agent a2);
void north(struct agent *a);
void east(struct agent *a);
void south(struct agent *a);
void west(struct agent *a);