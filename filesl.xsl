<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/TR/WD-xsl">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Tariffs</h2>
                <table border="1">
                    <tr bgcolor="#СС3300">
                        <th>Name</th>
                        <th>Operatorname</th>
                        <th>Payroll</th>
                        <th>Callprices</th>
                        <th>Smsprice</th>
                        <th>Parameters</th>
                    </tr>
                    <xsl:for-each select="tariffs/tariff">
                        <xsl:sort select="payroll" order="descending"/>
                        <tr>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="operatorname"/>
                            </td>
                            <td>
                                <xsl:value-of select="payroll"/>
                            </td>
                            <td>
                                <ul>
                                    <li>
                                        <span>insidenetworkcalls: </span>
                                        <xsl:value-of select="callprices/insidenetworkcalls"/>
                                    </li>
                                    <li>
                                        <span>outsidenetworkcalls: </span>
                                        <xsl:value-of select="callprices/outsidenetworkcalls"/>
                                    </li>
                                    <li>
                                        <span>landlinecalls: </span>
                                        <xsl:value-of select="callprices/landlinecalls"/>
                                    </li>
                                </ul>
                            </td>

                            <td>
                                <xsl:value-of select="smsprice"/>
                            </td>
                            <td>
                                <ul>
                                    <li>
                                        <span>favoritenumber: </span>
                                        <xsl:value-of select="parameters/favoritenumber"/>
                                    </li>
                                    <li>
                                        <span>connectioncost: </span>
                                        <xsl:value-of select="parameters/connectioncost"/>
                                    </li>
                                    <li>
                                        <span>promisedpayment: </span>
                                        <xsl:value-of select="parameters/promisedpayment"/>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

 

