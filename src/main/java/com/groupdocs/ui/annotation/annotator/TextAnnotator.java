package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.*;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

/**
 * TextAnnotator
 * Annotates documents with the text annotation
 *
 * @author Aspose Pty Ltd
 */
public class TextAnnotator extends AbstractSvgAnnotator {

    public TextAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
        setFixTop(false);
    }

    @Override
    public AnnotationInfo annotateWord() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        return textAnnotation;
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo textAnnotation = super.initAnnotationInfo();
        textAnnotation.setGuid(String.valueOf(annotationData.getId()));
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotatePdf() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateCells() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = super.initAnnotationInfo();
        // we use such calculation since the GroupDocs.Annotation library takes text line position from the bottom of the page
        double topPosition = pageData.getHeight() - annotationData.getTop();
        textAnnotation.setAnnotationPosition(new Point(annotationData.getLeft(), topPosition));
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateSlides() throws ParseException {
        // init possible types of annotations
        AnnotationInfo textAnnotation = initAnnotationInfo();
        return textAnnotation;
    }

    @Override
    public AnnotationInfo annotateImage() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    public AnnotationInfo annotateDiagram() {
        throw new UnsupportedOperationException(String.format(MESSAGE, annotationData.getType()));
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft() / 4, annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

    @Override
    protected byte getType() {
        return AnnotationType.Text;
    }
}