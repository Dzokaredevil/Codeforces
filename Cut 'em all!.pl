$_ = <>;

map {
	( $u, $v ) = split ' ', <>;
	$h{ $u }{ $v } ++;
	$h{ $v }{ $u } ++;
	} 2 .. $_; 

exit if $_ % 2 and print -1;

@g = ( 1 ) x ( $_ + 1 );

%N = %h;

while( @_ = grep 1 == keys %{ $h{ $_ } }, keys %N ){
					
	undef %N;
	
	for( @_ ){
		next if not $P = ( keys %{ $h{ $_ } } )[ 0 ];
		$N{ $P } ++;
		delete $h{ $P }{ $_ };
		delete $h{ $_ };
		
		$g[ $_ ] % 2 ? $g[ $P ] += $g[ $_ ] : ++ $C;
		}
	}

print 0 + $C
