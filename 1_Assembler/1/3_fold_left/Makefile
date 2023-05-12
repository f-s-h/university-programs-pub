CFLAGS=-O0

.PHONY: clean, all, main, debug

all: main
main: fold_left.c fold_left.S
	$(CC) $(CFLAGS) -o $@ $^
debug: fold_left.c fold_left.S
	$(CC) $(CFLAGS) -g -o $@ $^
clean:
	rm -f main debug
