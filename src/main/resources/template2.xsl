<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <articles>
            <xsl:for-each select="articles/articles">
                <articles>
                    <xsl:attribute name="id_art">
                        <xsl:value-of select="@id_art"/>
                    </xsl:attribute>
                    <xsl:attribute name="name">
                        <xsl:value-of select="@name"/>
                    </xsl:attribute>
                    <xsl:attribute name="code">
                        <xsl:value-of select="@code"/>
                    </xsl:attribute>
                    <xsl:attribute name="username">
                        <xsl:value-of select="@username"/>
                    </xsl:attribute>
                    <xsl:attribute name="guid">
                        <xsl:value-of select="@guid"/>
                    </xsl:attribute>
                </articles>
            </xsl:for-each>
        </articles>
    </xsl:template>
</xsl:stylesheet>