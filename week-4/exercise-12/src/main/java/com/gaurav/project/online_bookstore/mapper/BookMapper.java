package com.gaurav.project.online_bookstore.mapper;

import com.gaurav.project.online_bookstore.dto.BookDTO;
import com.gaurav.project.online_bookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);
}
