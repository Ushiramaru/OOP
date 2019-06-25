package Configuration;

import java.awt.*;

public class Configurator {

    private String paintTitle = "недоPaint";
    private Color paintColor = Color.WHITE;
    private int paintHeight = 500;
    private int paintWidth = 900;

    private Color panelShapeColor = Color.GRAY;
    private int panelShapeHeight = 40;
    private int panelShapeGapX = 10;

    private Color buttonShapeColor = Color.MAGENTA;
    private int buttonShapeHeight = 20;
    private int buttonShapeWidth = 70;

    private Color panelUserShapeColor = Color.GRAY;
    private int panelUserShapeWidth = 100;
    private int panelUserShapeGapY = 10;

    private Color buttonUserShapeColor = Color.MAGENTA;
    private int buttonUserShapeHeight = 20;
    private int buttonUserShapeWidth = 70;

    public String getPaintTitle() {
        return paintTitle;
    }

    public void setPaintTitle(String paintTitle) {
        if (paintTitle != null) {
            this.paintTitle = paintTitle;
        }
    }

    public Color getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(String paintColor) {
        if (paintColor != null) {
            if (paintColor.equals("WHITE")) {
                this.paintColor = Color.WHITE;
            } else {
                if (paintColor.equals("BLACK")) {
                    this.paintColor = Color.BLACK;
                } else {
                    if (paintColor.equals("GRAY")) {
                        this.paintColor = Color.GRAY;
                    } else {
                        if (paintColor.equals("MAGENTA")) {
                            this.paintColor = Color.MAGENTA;
                        } else {
                            if (paintColor.equals("BLUE")) {
                                this.paintColor = Color.BLUE;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPaintHeight() {
        return paintHeight;
    }

    public void setPaintHeight(int paintHeight) {
        this.paintHeight = paintHeight;
    }

    public int getPaintWidth() {
        return paintWidth;
    }

    public void setPaintWidth(int paintWidth) {
        this.paintWidth = paintWidth;
    }

    public Color getPanelShapeColor() {
        return panelShapeColor;
    }

    public void setPanelShapeColor(String panelShapeColor) {
        if (panelShapeColor != null) {
            if (panelShapeColor.equals("WHITE")) {
                this.panelShapeColor = Color.WHITE;
            } else {
                if (panelShapeColor.equals("BLACK")) {
                    this.panelShapeColor = Color.BLACK;
                } else {
                    if (panelShapeColor.equals("GRAY")) {
                        this.panelShapeColor = Color.GRAY;
                    } else {
                        if (panelShapeColor.equals("MAGENTA")) {
                            this.panelShapeColor = Color.MAGENTA;
                        } else {
                            if (panelShapeColor.equals("BLUE")) {
                                this.panelShapeColor = Color.BLUE;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPanelShapeHeight() {
        return panelShapeHeight;
    }

    public void setPanelShapeHeight(int panelShapeHeight) {
        this.panelShapeHeight = panelShapeHeight;
    }

    public int getPanelShapeGapX() {
        return panelShapeGapX;
    }

    public void setPanelShapeGapX(int panelShapeGapX) {
        this.panelShapeGapX = panelShapeGapX;
    }

    public Color getButtonShapeColor() {
        return buttonShapeColor;
    }

    public void setButtonShapeColor(String buttonShapeColor) {
        if (buttonShapeColor != null) {
            if (buttonShapeColor.equals("WHITE")) {
                this.buttonShapeColor = Color.WHITE;
            } else {
                if (buttonShapeColor.equals("BLACK")) {
                    this.buttonShapeColor = Color.BLACK;
                } else {
                    if (buttonShapeColor.equals("GRAY")) {
                        this.buttonShapeColor = Color.GRAY;
                    } else {
                        if (buttonShapeColor.equals("MAGENTA")) {
                            this.buttonShapeColor = Color.MAGENTA;
                        } else {
                            if (buttonShapeColor.equals("BLUE")) {
                                this.buttonShapeColor = Color.BLUE;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getButtonShapeHeight() {
        return buttonShapeHeight;
    }

    public void setButtonShapeHeight(int buttonShapeHeight) {
        this.buttonShapeHeight = buttonShapeHeight;
    }

    public int getButtonShapeWidth() {
        return buttonShapeWidth;
    }

    public void setButtonShapeWidth(int buttonShapeWidth) {
        this.buttonShapeWidth = buttonShapeWidth;
    }

    public Color getPanelUserShapeColor() {
        return panelUserShapeColor;
    }

    public void setPanelUserShapeColor(String panelUserShapeColor) {
        if (panelUserShapeColor != null) {
            if (panelUserShapeColor.equals("WHITE")) {
                this.panelUserShapeColor = Color.WHITE;
            } else {
                if (panelUserShapeColor.equals("BLACK")) {
                    this.panelUserShapeColor = Color.BLACK;
                } else {
                    if (panelUserShapeColor.equals("GRAY")) {
                        this.panelUserShapeColor = Color.GRAY;
                    } else {
                        if (panelUserShapeColor.equals("MAGENTA")) {
                            this.panelUserShapeColor = Color.MAGENTA;
                        } else {
                            if (panelUserShapeColor.equals("BLUE")) {
                                this.panelUserShapeColor = Color.BLUE;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPanelUserShapeWidth() {
        return panelUserShapeWidth;
    }

    public void setPanelUserShapeWidth(int panelUserShapeWidth) {
        this.panelUserShapeWidth = panelUserShapeWidth;
    }

    public int getPanelUserShapeGapY() {
        return panelUserShapeGapY;
    }

    public void setPanelUserShapeGapY(int panelUserShapeGapY) {
        this.panelUserShapeGapY = panelUserShapeGapY;
    }

    public Color getButtonUserShapeColor() {
        return buttonUserShapeColor;
    }

    public void setButtonUserShapeColor(String buttonUserShapeColor) {
        if (buttonUserShapeColor != null) {
            if (buttonUserShapeColor.equals("WHITE")) {
                this.buttonUserShapeColor = Color.WHITE;
            } else {
                if (buttonUserShapeColor.equals("BLACK")) {
                    this.buttonUserShapeColor = Color.BLACK;
                } else {
                    if (buttonUserShapeColor.equals("GRAY")) {
                        this.buttonUserShapeColor = Color.GRAY;
                    } else {
                        if (buttonUserShapeColor.equals("MAGENTA")) {
                            this.buttonUserShapeColor = Color.MAGENTA;
                        } else {
                            if (buttonUserShapeColor.equals("BLUE")) {
                                this.buttonUserShapeColor = Color.BLUE;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getButtonUserShapeHeight() {
        return buttonUserShapeHeight;
    }

    public void setButtonUserShapeHeight(int buttonUserShapeHeight) {
        this.buttonUserShapeHeight = buttonUserShapeHeight;
    }

    public int getButtonUserShapeWidth() {
        return buttonUserShapeWidth;
    }

    public void setButtonUserShapeWidth(int buttonUserShapeWidth) {
        this.buttonUserShapeWidth = buttonUserShapeWidth;
    }

}