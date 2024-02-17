package com.bookmanagement.customvalidation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookmanagement.model.Book;

public class PastPresentValidaion  implements ConstraintValidator<PastPresentYearValidation, Book>{

	@Override
    public boolean isValid(Book book, ConstraintValidatorContext context) {
        if (book == null) {
            // Null values are considered valid, use @NotNull for not-null validation
            return true;
        }

        int currentYear = LocalDate.now().getYear();
        return book.getPublicationYear() <= currentYear;
    }

}
