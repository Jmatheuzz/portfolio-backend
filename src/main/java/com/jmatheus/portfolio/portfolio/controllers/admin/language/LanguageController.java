package com.jmatheus.portfolio.portfolio.controllers.admin.language;

import com.jmatheus.portfolio.portfolio.responses.ResponseOk;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.CreateLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.DeleteLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.ShowLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.UpdateLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.CreatedLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.ListedLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.ShowedLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.UpdatedLanguageDto;
import com.jmatheus.portfolio.portfolio.services.language.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/language")
public class LanguageController {
    @Autowired
    private InsertLanguageService insertLanguageService;

    @Autowired
    private ListLanguageService listLanguageService;

    @Autowired
    private ShowLanguageService showLanguageService;

    @Autowired
    private UpdateLanguageService updateLanguageService;

    @Autowired
    private DeleteLanguageService deleteLanguageService;

    @GetMapping
    public ResponseEntity<ResponseOk> list() {
        ListedLanguageDto listedLanguage = listLanguageService.execute();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOk("Success", listedLanguage.getData()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> show(@PathVariable Long id) {
        ShowedLanguageDto showedLanguage = showLanguageService.execute(new ShowLanguageDto(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOk("Success", showedLanguage.getData()));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> create(@RequestBody CreateLanguageDto data) {
        CreatedLanguageDto createdLanguage = insertLanguageService.execute(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseOk("Created", createdLanguage));
    }

    @PutMapping
    public ResponseEntity<ResponseOk> update(@RequestBody UpdateLanguageDto data) {
        UpdatedLanguageDto updatedLanguage = updateLanguageService.execute(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseOk("Success", updatedLanguage.getData()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteLanguageService.execute(new DeleteLanguageDto(id));
        return ResponseEntity.noContent().build();
    }
}
