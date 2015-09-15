#lang racket
(define (prep-pd l)
  (filter (lambda (x)
            (and (> (char->integer x) 96) (< (char->integer x) 123))) l))

(define (palindrome p)
  (cond
    [(equal? (prep-pd (string->list (string-downcase p)))
             (reverse (prep-pd (string->list (string-downcase p))))) "Palindrome"]
    [else "Not a palindrome"]))

